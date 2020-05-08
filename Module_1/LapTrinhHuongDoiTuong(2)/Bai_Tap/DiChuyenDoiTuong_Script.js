function Hero(image, top, left, size) {
    this.image = image;
    this.top = top;
    this.left = left;
    this.size = size;

    this.getHeroElement = function () {
        return '<img width="' + this.size + '"' +
            ' height="' + this.size + '"' +
            ' src="' + this.image + '"' +
            ' style="top: ' + this.top + 'px; left:' + this.left + 'px;position:absolute;" />';
    };
    this.setSpeed = function (speed) {
        this.speed = speed;
    };
    this.moveRight = function () {
        this.left += this.speed;
    };
    this.moveDown = function () {
        this.top += this.speed;
    };
    this.moveLeft = function () {
        this.left -= this.speed;
    };
    this.moveUp = function () {
        this.top -= this.speed;
    };
}

let hero = new Hero('ChauTinhTri.jpg', 20, 30, 200);
hero.setSpeed(100);
let check1 = true;
let check2 = true;
function start() {

    if (hero.left < window.innerWidth - hero.size && check1 === true) {
        hero.moveRight();
        check2 = false;
    } else if (hero.top < window.innerHeight - hero.size && check2 === false) {
        hero.moveDown();
        check1 = false;
    } else if (hero.left > 30 && check1 === false) {
        hero.moveLeft();
        check2 = true;
    } else if (hero.top > 20 && check2 === true) {
        hero.moveUp();
    } else {
        check1 = true;
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();
