// const user = {
//     name: "pooja",
//     email :"poojakundala@gmail.com",
//     isactive:"true"
// }

// function createuser({name:string,ispaid:boolean}){

// }

// createuser({name:"pooja",ispaid:true})


// function createcourse() : {name:string,price:number}{
//     return {name :"reactjs",price : 399}
// }

// function createuser1({name:string}){}
//     let newuser = {name:"pooja",email:"pooja@gmail.com",pho:"9014328132"}

// createuser1(newuser)


// type user = {
//     name:string;
//     email:string;
//     isactive :boolean
// }

// function create(user:user):user{
//     return {name: "",email:"",isactive:true}
// }
// create({name:"",email:"",isactive:true})


type user = {
    readonly _id:string
    name:string
    email:string
    isactive :boolean
    creditcard?:number//? is for optional
}

let myuser:user={
    _id:"342",
    name:"pooja",
    email:"pooja@gmail.com",
    isactive:true,

}

//mix and match of type

type cardnumber = {
    card_number:string
}

type carddate = {
    carddate:string
}

type carddetails = cardnumber & carddate &{
    cvv :number
}


export {}