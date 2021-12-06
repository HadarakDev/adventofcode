const fs = require('fs')


function readInputFile(err, data) {
    let duplicate = []
    let lines = data.split('\n')

    let regex = /\d/g
    for (let idx in lines) {
        let numbers = lines[idx].match(regex)
        console.log(numbers)
    }
    return data

}


fs.readFile('input.txt', 'utf8', readInputFile)

