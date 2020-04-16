function Hero(image,top,left,size) {
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

function start() {
    if (hero.left < window.innerWidth - hero.size) {
        hero.moveRight();
    }else if (hero.top < window.innerHeight - hero.size) {
        hero.moveDown();
    }
    else if (hero.left > 30) {
        hero.moveLeft();
    } else if (hero.top > 20) {
        hero.moveUp();
    }
    document.getElementById('game').innerHTML = hero.getHeroElement();
    setTimeout(start, 500)
}

start();