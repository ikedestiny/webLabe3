document.addEventListener("DOMContentLoaded",function () {
    const currentX = document.querySelector("#currentX");

    let xButtons = document.getElementsByClassName("xb");

  function setX(value){
      currentX.innerHTML = value;
      console.log(currentX)
  }


    for(let x in xButtons){
        x.addEventListener("click",($event)=>{
            $event.preventDefault();
            setX(x.value)
        })
    }

})