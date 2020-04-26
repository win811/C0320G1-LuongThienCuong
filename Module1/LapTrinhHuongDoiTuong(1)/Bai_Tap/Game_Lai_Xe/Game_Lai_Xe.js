const GAMEBOARD_WIDTH = 500;
const GAMEBOARD_HEIGHT = 500;

const ORIENTATION_LEFT = "left";
const ORIENTATION_RIGHT = "right";
const ORIENTATION_UP = "up";
const ORIENTATION_DOWN = "down";

const CAR_WIDTH = 60;
const CAR_HEIGHT = 90;

const DEFAULT_CAR_X_POSITION = 100;
const DEFAULT_CAR_Y_POSITION = 100;
const DEFAULT_CAR_ORIENTATION = ORIENTATION_DOWN;
const DEFAULT_CAR_SPEED = 20;

function Car() {
    this.xPosition = DEFAULT_CAR_X_POSITION;
    this.yPosition = DEFAULT_CAR_Y_POSITION;
    this.orientation = DEFAULT_CAR_ORIENTATION;
    this.speed = DEFAULT_CAR_SPEED;

    this.buildImage = function () {
        this.image = this.orientation + 'car.png';
    };

    this.buildImage();

    this.move = function () {
        switch (this.orientation) {
            case ORIENTATION_DOWN:
                this.yPosition += this.speed;
                break;
            case ORIENTATION_UP:
                this.yPosition -= this.speed;
                break;
            case ORIENTATION_LEFT:
                this.xPosition -= this.speed;
                break;
            case ORIENTATION_RIGHT:
                this.xPosition += this.speed;
                break;
        }
        this.buildImage();
    };

    // this.turn = function (orientation) {
    //     this.orientation = orientation;
    //     this.buildImage();
    // };
    this.show = function(ctx){
        let image = new Image();
        let xPosition = this.xPosition;
        let yPosition = this.yPosition;
        image.src = this.image;
        image.onload = function(){
            ctx.drawImage(image, xPosition, yPosition,CAR_WIDTH,CAR_HEIGHT);
        };
    }
}

function GameBoard() {
    this.car = new Car();
    this.ctx = undefined;
    this.start = function(){
        this.ctx = document.getElementById('gameCanvas').getContext('2d');
        this.car.show(this.ctx);
    };

    this.render = function(){
        this.ctx.clearRect(0, 0, GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
        this.car.show(this.ctx);
    };

    this.moveCar = function(event){
        let orientation = 0;
        switch (event.keyCode){
            case 37:
                orientation = ORIENTATION_LEFT;
                break;
            case 38:
                orientation = ORIENTATION_UP;
                break;
            case 39:
                orientation = ORIENTATION_RIGHT;
                break;
            case 40:
                orientation = ORIENTATION_DOWN;
                break;
        }

        if(orientation){
            if(this.car.orientation !== orientation){
                this.car.orientation = orientation;
            } else {
                this.car.move();
            }
            this.render();
        }
    }
}

let gameBoard = new GameBoard();
gameBoard.start();
function moveCar(event) {
    gameBoard.moveCar(event);
}