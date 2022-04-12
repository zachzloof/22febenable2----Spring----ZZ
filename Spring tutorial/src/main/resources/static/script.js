'use strict'


//DOMS
const inputOne = document.getElementById(`input_1`);
const output = document.getElementById(`output`)
const buttonGet = document.getElementById(`buttonGet`);
const listOutput = document.querySelector(`ol`);
const buttonGetList = document.getElementById(`buttonGetList`);
      let response1 = [];
let read = () => {
    


  axios.get(`http://localhost:8080/getAll`)
  .then((response) => {
    if (!Array.isArray(response.data)) {
      writeItem(response.data);
    } else {
      for (let item of response.data) {
        writeItem(item);
      }
    }
  }).catch((err) => {
    console.log(err);
  });

}
let get = () => {
    let response1 = [];
    axios.request(options).then(function (response) {
        //console.log((response.data));
       response1 = (response.data);
       for (let i = 0; i < response1.length; i++) {
         
         console.log(response)
         output.innerHTML = response1[i].title;
     }
       output.innerHTML = (JSON.stringify(response.data[inputOne.value]));
   }).catch(function (error) {
       console.error(error);
   });
}
const writeItem = item => {
    let child = document.createElement(`li`);
    child.innerHTML = `${JSON.stringify(item)}`;
    listOutput.appendChild(child);
    // setTimeout(function() {
    //   child = child + " fade show";
    // }, 10);
    // setTimeout();
  }
  const list = () => {
    listOutput.innerHTML = ``;
  
      axios.request(options).then(function (response) {
        //console.log((response.data));
       response1 = (response.data);
       for (let i = 0; i < response1.length; i++) {
         
         writeItem(response1[i].title)
     }
       output.innerHTML = (JSON.stringify(response.data[inputOne.value]));
   }).catch(function (error) {
       console.error(error);
   });
  }

buttonGet.onclick = () => read();
buttonGetList.onclick = () => list();




