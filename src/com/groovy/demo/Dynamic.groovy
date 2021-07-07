package com.groovy.demo
def cat="Meow"
def one=1
println cat
println cat.getClass()
println cat.toUpperCase()

println one
println one.getClass()
//println one.toUpperCase() // type does not support
//groovy does not force type checking at compile type 
//it checks only at runtime due groovy dynamic nature
// we can enable static type checking but we will loose it dynamic
// language features
one="Sagar"
// it anables doc typing, we can assign int type to string
it walks like duck, talks like duck , it must be duck 

println one
println one.getClass()
