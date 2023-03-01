// function addtwo(num){
//     num.toUpperCase();
//     return num+2;
// }

// addtwo("5");

function addtwo(num:number){
    num.toFixed();
    return num+2;
}

function UpperCase(val){
    return val.toUpperCase()

}

UpperCase(4);
UpperCase("pooja")


function signin(name:string,email:string,ispaid:boolean){}
signin("pooja","poo@gmail.com",false)

function signinuser(name:string,email:string,ispaid:boolean = false){}
signinuser("pooja","poo@gmail.com")
addtwo(5);

function add(num:number):number{
    return num+2;
}
add(2)

// function getvalue(num:number) : boolean{
//     if(num>5)
//     {
//         return true;
//     }
//     else{
//         return "200 ok";
//     }
// }


const gethello  = (s:string):string{
    return "";
}
const heros = ["alluarjun","mahesh babu", "darling"];

heros.map((hero):string=>{
    return `hero is ${hero}`;
})


function consoleError(errmsg:string):void{
    console.log(errmsg);
}

function handleError(errmsg:string):never{
    throw new Error(errmsg);
}
export {}