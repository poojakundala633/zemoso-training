const trigger = document.getElementById('trigger');
const modalwrapper = document.querySelector(".modal_wraper")
const crossbtn = document.querySelector(".cross");
const submit = document.querySelector("#submit")
trigger.addEventListener('click',function(){
    modalwrapper.classList.add('active');
})

crossbtn.addEventListener('click',function(){
    modalwrapper.classList.remove('active');
})

submit.addEventListener('click',function(){
    alert("Thank you!!");
})