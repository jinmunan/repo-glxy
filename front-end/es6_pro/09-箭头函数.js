let arr = ["10", "5", "40", "25", "1000"]
// arr.sort(function(a,b){
//     return a - b
// })

arr.sort((a, b) => a - b)

console.log(arr)