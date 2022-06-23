function showInfo(name, age = 25){
    if(age){
        console.log('showInfo true' + name + ', ' + age)
    }else{
        console.log('showInfo false' + name)
    }
}

showInfo('国哥', 18)
showInfo('国哥')
showInfo('国哥', undefined)
showInfo('国哥', null)