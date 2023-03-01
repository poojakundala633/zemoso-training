interface user_det{
    readonly dbid: number,
    email:string,
    userid:number,
    googleid?: string,
    starttrail():string,
    getcoupon(couponname:string):number
}
interface user_det{
    github_token?:string,
}

//inherit
interface admin1 extends user_det{
    role ?:"admin" | "ta",
} 
const pooja1:user_det = {dbid:22,email: "poo@gamil.com",userid:212,starttrail:()=>{
    return "trail started";
},
getcoupon:(name: "POOJA134") =>{
    return 10
}}

const me :admin1 = {dbid: 34,email: "poo@gamil.com",userid:212,starttrail:()=>{
    return "trail started";
},
getcoupon:(name: "POOJA134") =>{
    return 10
}}
pooja1.email = "pooja@gmail.com"
// pooja.dbid = 22