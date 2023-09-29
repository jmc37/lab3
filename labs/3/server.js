const http = require('http');
const url = require('url')
const fs = require('fs'); // Added to interact with the file system

const util = require('./modules/util')

const hostname = '127.0.0.1'; // Change from '127.0.0.1' to '0.0.0.0'
const port = process.env.PORT || 3000; // Use the PORT environment variable if provided
const server = http.createServer(function(req,res){
    let parsedUrl = url.parse(req.url, true);
    if (parsedUrl.pathname.startsWith("/writeFile")) {
        let text = parsedUrl.query.text;
        // Append text to file.txt
        fs.appendFile('file.txt', text + '\n', function(err) {
            if (err) throw err;
            console.log('Text appended to file.txt');
        });

        res.write('Text appended to file.txt');
        res.end();

    }
    else if (parsedUrl.pathname ===("/readFile/file.txt*")) {
        let text = parsedUrl.query.text;
        res.write(text);
        res.end();

    }
    else if(parsedUrl.pathname === "/"){
    let q = url.parse(req.url, true).query;
    let response = util.getDate(q.name)
    response = `<div style="color: blue;">${response}</div>`;
    res.write(response)
    res.end();
    }
})

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}/`);
});