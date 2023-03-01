"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
const head = document.getElementById('heading');
console.log(head);
setTimeout(() => {
    head.innerHTML = "This is dom using typeasript";
    console.log(head);
}, 1000);
console.log(head);
const btn = document.querySelector('#button');
btn.addEventListener('click', () => {
    let number1 = document.getElementById('number1').valueAsNumber;
    let number2 = document.getElementById('number2').valueAsNumber;
    let result = add1(number1, number2);
    console.log(`The addition of ${number1} and ${number2} is : `, result);
});
function add1(number1, number2) {
    let result = number1 + number2;
    return result;
}
const list = document.querySelectorAll(".list_items");
console.log(list);
list.forEach((item) => {
    item.addEventListener('click', () => {
        item.style.color = "white";
        item.style.backgroundColor = "black";
        console.log("hello");
    });
    console.log(item);
});
//call back and promises assignment in typescript
function getData(uId) {
    return __awaiter(this, void 0, void 0, function* () {
        var mail = new Promise((resolve, reject) => {
            setTimeout(() => {
                console.log("Fetched the data!");
                resolve(`${uId}@gmail.com`);
            }, 1000);
        });
        console.log("start");
        let email = yield mail;
        console.log(`Email id of the user id is: ${email}`);
        console.log("end");
    });
}
getData('skc');
//promises
function first(value, error) {
    let res1 = new Promise((resolve, reject) => {
        if (!error) {
            setTimeout(() => {
                console.log('value in first function before adding is ' + value);
                resolve(value + 10);
            }, 1000);
        }
        else {
            reject("Something went wrong in first function");
        }
    });
    res1.then((result1) => second(result1, false))
        .catch((error) => console.log(error));
}
function second(value, error) {
    let res2 = new Promise((resolve, reject) => {
        if (!error) {
            setTimeout(() => {
                console.log('value in second function before adding is ' + value);
                resolve(value + 10);
            }, 1000);
        }
        else {
            reject("Something went wrong in second function");
        }
    });
    res2.then((result2) => third(result2, false))
        .catch((error) => console.log(error));
}
function third(value, error) {
    let res3 = new Promise((resolve, reject) => {
        if (!error) {
            setTimeout(() => {
                console.log('value in third function before adding is ' + value);
                resolve(value + 10);
            }, 1000);
        }
        else {
            reject("Something went wrong in third function");
        }
    });
    res3.then((result3) => console.log(`the total result ${result3}`))
        .catch((error) => console.log(error));
}
first(10, false);
let head2 = document.getElementsByTagName("h2")[0];
console.log(head2);
setTimeout(() => {
    head2.innerHTML = `This is heading 2`;
    head2.style.height = "100px";
    head2.style.backgroundColor = "black";
    head2.style.color = "yellow";
}, 1000);
