//if we dont know what value it is going to take then instead of any we use union

let score:number | string = 33
type user1 = {
    name:string,
    id: number,
}
type admin = {
    username : string,
    id : number
}

let pooja: user1 | admin = {name:"pooja",id:334}

pooja = {username :"pj", id:334}

function getdbid(id:number | string){
    //some apis
    console.log(`db id is: ${id} `);
}

getdbid(3)
getdbid("3")

const data:number[] = [1,2,3]
const data2:string[] = ["1","2","3"]
const data3 :(string|number)[] = ["1",2,"abc"]

let seatmang : "aisle" | "middile" | "window";