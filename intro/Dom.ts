
const head=document.getElementById('heading') as HTMLElement;
console.log(head);
setTimeout(()=>{
    head.innerHTML="This is dom using typeasript";
    console.log(head);
},1000);
console.log(head);
const btn=document.querySelector('#button') as HTMLElement;
btn.addEventListener('click',()=>{
    let number1 =(document.getElementById('number1')! as HTMLInputElement).valueAsNumber; 
    let number2 =(document.getElementById('number2')! as HTMLInputElement).valueAsNumber;
    let result=add1(number1,number2);
    console.log(`The addition of ${number1} and ${number2} is : `,result);
})
function add1(number1:number,number2:number):number{    
        let result=number1+number2;
        return result;
}
const list=document.querySelectorAll<HTMLElement>(".list_items");
console.log(list);
    list.forEach((item)=>{
        item.addEventListener('click',()=>{
            item.style.color="white";
            item.style.backgroundColor="black";
            console.log("hello");
        })
        console.log(item);
    })
//call back and promises assignment in typescript
async function getData(uId:string): Promise<void> {
    var mail=new Promise<string>((resolve,reject)=>{
        setTimeout(() => {
        console.log("Fetched the data!");
        resolve(`${uId}@gmail.com`);
        }, 1000);
    })
    console.log("start");
    let email :string =await mail;
    console.log(`Email id of the user id is: ${email}`);
    console.log("end");
}
getData('skc');

//promises
function first(value:number,error:boolean){
    let res1= new Promise<number>((resolve, reject) =>{
        if(!error){
            setTimeout(()=>{
                console.log('value in first function before adding is '+value);
                resolve(value+10);
            },1000)
        }
        else{
            reject("Something went wrong in first function");
        }
    })
    res1.then((result1:number)=>second(result1,false))
    .catch((error:boolean)=>console.log(error))
}
function second(value:number,error:boolean){
    let res2= new Promise<number>((resolve, reject) =>{
        if(!error){
            setTimeout(()=>{
                console.log('value in second function before adding is '+value);
                resolve(value+10);
            },1000)
        }
        else{
            reject("Something went wrong in second function");
        }
    })
    res2.then((result2:number)=>third(result2,false))
    .catch((error:boolean)=>console.log(error))
}
function third(value:number,error:boolean){
    let res3= new Promise<number>((resolve, reject) =>{
        if(!error){
            setTimeout(()=>{
                console.log('value in third function before adding is '+value);
                resolve(value+10);
            },1000)
        }
        else{
            reject("Something went wrong in third function");
        }
    })
    res3.then((result3:number)=>console.log(`the total result ${result3}`))
    .catch((error:boolean)=>console.log(error))
}
first(10,false);
let head2=document.getElementsByTagName("h2")[0] as HTMLHeadingElement;
console.log(head2);
setTimeout(()=>{
     head2.innerHTML=`This is heading 2`;
     head2.style.height="100px";
     head2.style.backgroundColor="black";
     head2.style.color="yellow";
},1000)