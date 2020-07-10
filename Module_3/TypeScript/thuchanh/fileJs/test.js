function main() {
    var x = 5;
    console.log(x);
    var x = 10;
    console.log(x);
    var y = 55;
    console.log(y);
    var y = 100;
    console.log(y);
    var z = 10001111;
    console.log(z);
}
main();
// -------------------------
let count = 50;
if (count > 0) {
    count--;
}
else {
    count = 0;
}
console.log(count);
/**
 * loop
 */
console.log("for loop");
const keys = "abcdef";
for (let idx = 0; idx < keys.length; ++idx) {
    console.log(keys[idx]);
}
console.log("while loop");
let idx = 0;
while (idx < keys.length) {
    console.log(keys[idx]);
    ++idx;
}
console.log("do-while loop");
idx = 0;
do {
    console.log(keys[idx]);
    ++idx;
} while (idx < keys.length);
console.log("for-of loop");
for (const item of keys) {
    console.log(item);
}
console.log("for-in loop");
const user = {
    name: 'Bob',
    age: 55
};
for (const key in user) {
    console.log(`${key}: ${user[key]}`);
}
//----------------------
const list = [1, 2, 3];
const categories = ['Sport', 'IT', 'Car'];
console.log('list');
list.forEach((num) => console.log(num.toFixed(2)));
console.log('categries');
categories.forEach((str) => console.log(str.includes('a')));
// convert mảng từ dạng này sang dạng khác.
const listSquare = list.map(num => num * num);
console.log(listSquare);
// Output: [1, 4, 9]
// lọc các phần tử thỏa mãn
const result = categories.filter(str => str.length > 2);
console.log(result);
// Output: ['Sport', 'Car']
/**
 * Tuple
 */
// Declare a tuple type
let x;
// Initialize it
x = ["hello", 10]; // OK
// Initialize it incorrectly
// x = [10, "hello"]; // Error
console.log(x[0].substr(1)); // OK
// console.log(x[1].substr(1));
// Error, Property 'substr' does not exist on type 'number'.
//-------------------------
function square(num) {
    return num * num;
}
console.log(square(5));
// Output: 25
// Function expression
const squareFE = function (num) {
    return num * num;
};
// Higher-order function
function add(a) {
    return function (b) {
        return a + b;
    };
}
const addWith5 = add(5);
console.log(add(5)(5));
console.log(addWith5(15));
let customer = {
    name: 'Bob',
    age: 50
};
console.log(customer);
/* customer = {
  name: 'Anna'
}; */
/*
* Error: Type '{ name: string; }' is not assignable to type 'IUser'.
* Property 'age' is missing in type '{ name: string; }'.
*/
class Shape {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
    toString() {
        return `(x: ${this.x}, y: ${this.y})`;
    }
}
class Rect extends Shape {
    constructor(x, y, width, height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    area() {
        return this.width * this.height;
    }
}
const rect = new Rect(5, 5, 10, 20);
console.log(rect.toString());
console.log(rect.area());
