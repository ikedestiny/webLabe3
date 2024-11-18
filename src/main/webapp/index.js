document.addEventListener("DOMContentLoaded",function () {
  //TODO set x y when graph is clicked and trigger the click method of form submit button
    const svg = document.querySelector(".svg-graph")

    window.svgClick =   function(event){
        const rect = svg.getBoundingClientRect();
        const xClick = event.clientX - rect.left;
        const yClick = event.clientY - rect.top;

        // Map SVG coordinates (pixel space) to graph coordinates (-3 to 3)
        const xCoord = ((xClick - 280) / 65.3333).toFixed(2);  // scale: 39.2px per unit
        const yCoord = ((280 - yClick) / 65.3333).toFixed(2);

        if (xCoord < 5 && yCoord <5){
            handleClick(xCoord,yCoord)
        drawCircle(xClick,yClick)

        }


    }


    function drawCircle(x,y){
        let circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("r", 5);
        circle.setAttribute("cx", x);
        circle.setAttribute("cy", y                       );
        circle.setAttribute("fill", "red");

        // Append the circle to the SVG
        svg.appendChild(circle);
    }



    function handleClick(x,y){
        document.getElementById("main-form:currentX").value = x;
        document.getElementById("main-form:y").value = y;
        document.getElementById("main-form:submit").click()
        console.log("click req sent")

    }


})