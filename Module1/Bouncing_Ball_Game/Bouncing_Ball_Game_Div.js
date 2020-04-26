const DEFAULT_BOARD_X_POSITION = 0;
const DEFAULT_BOARD_Y_POSITION = 0;
const DEFAULT_BOARD_WIDTH = 500;
const DEFAULT_BOARD_HEIGHT = 500;

const DEFAULT_BALL_SRC = "Images/GolfBall.png";
const DEFAULT_BALL_X_POSITION = 250;
const DEFAULT_BALL_Y_POSITION = 250;
const DEFAULT_BALL_WIDTH = 20;
const DEFAULT_BALL_HEIGHT = 20;
const RANDOM_BALL_ANGLE_X = 10;
const RANDOM_BALL_ANGLE_Y = 5;

const DEFAULT_BAR_SRC = "Images/Bar.png";
const DEFAULT_BAR_X_POSITION = 200;
const DEFAULT_BAR_Y_POSITION = 400;
const DEFAULT_BAR_WIDTH = 120;
const DEFAULT_BAR_HEIGHT = 20;
const DEFAULT_BAR_DISTANCE = 10;

const DIRECTION_TOP_LEFT = 'topLeft';
const DIRECTION_TOP_RIGHT = 'topRight';
const DIRECTION_DOWN_LEFT = 'downLeft';
const DIRECTION_DOWN_RIGHT = 'downRight';

class Ball {
    constructor(src, left, top, width, height) {
        this.src = src;
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    getElement() {
        return '<img src="' + this.src +
            '" style="position: absolute;' +
            'left:' + this.left + 'px;' +
            'top:' + this.top + 'px;' +
            'width:' + this.width + 'px;' +
            'height:' + this.height + 'px"/>';
    }

    move(direction, angleX, angleY) {
        switch (direction) {
            case DIRECTION_TOP_RIGHT :
                this.left += angleX;
                this.top -= angleY;
                break;
            case DIRECTION_TOP_LEFT :
                this.left -= angleX;
                this.top -= angleY;
                break;
            case DIRECTION_DOWN_LEFT :
                this.left -= angleX;
                this.top += angleY;
                break;
            case DIRECTION_DOWN_RIGHT :
                this.left += angleX;
                this.top += angleY;
        }
    }
}

class Bar extends Ball {
    constructor(src, left, top, width, height, distance) {
        super(src, left, top, width, height);
        this.distance = distance;
    }

    moveLeft() {
        this.left -= this.distance;
    }

    moveRight() {
        this.left += this.distance;
    }
}

class GameBoard {
    constructor(left, top, width, height, ball, bar) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.ball = ball;
        this.bar = bar;
    }

    getElement() {
        return '<div id="div2" style="position: relative ;border: 1px solid black;background-color: lightblue; ' +
            'left:' + this.left + 'px;' +
            'top:' + this.top + 'px;' +
            'width:' + this.width + 'px;' +
            'height: ' + this.height + 'px;"></div>';
    }

    render() {
        document.getElementById('div2').innerHTML = this.ball.getElement() + this.bar.getElement();
    }

    start() {
        this.isOver = false;
        document.getElementById('div1').innerHTML = this.getElement();
        this.render();
    }

    setDefaultAngle(angleX,angleY) {
        this.nowAngleX = angleX;
        this.nowAngleY = angleY;
    }

    setDefaultDirection(direction) {
        this.nowDirection = direction;
    }

    checkStatusBall () {
        if ((this.ball.top + this.ball.height) === this.bar.top &&
            this.ball.left >= (this.bar.left - this.ball.width / 2) &&
            this.ball.left <= (this.bar.left + this.bar.width - this.ball.width / 2)) {
            return 'touchBar';
        } else if ((this.ball.left + this.ball.width) === (this.left + this.width)) {
            return 'touchRightBorder';
        } else if (this.ball.left === this.left) {
            return 'touchLeftBorder';
        } else if (this.ball.top === this.top) {
            return 'touchTop';
        } else if ((this.ball.top + this.ball.height) === (this.top + this.height)) {
            return 'touchBottom';
        }
    }

    check_get_direction_and_angle() {

        this.previousDirection = this.nowDirection;

        switch (this.checkStatusBall()) {
            case 'touchBar' :
                if (this.previousDirection === DIRECTION_DOWN_RIGHT) {
                    this.nowDirection = DIRECTION_TOP_RIGHT;
                } else if (this.previousDirection === DIRECTION_DOWN_LEFT) {
                    this.nowDirection = DIRECTION_TOP_LEFT;
                }
                break;
            case 'touchRightBorder' :
                if (this.previousDirection === DIRECTION_TOP_RIGHT) {
                    this.nowDirection = DIRECTION_TOP_LEFT;
                } else if (this.previousDirection === DIRECTION_DOWN_RIGHT) {
                    this.nowDirection = DIRECTION_DOWN_LEFT;
                }
                break;
            case 'touchLeftBorder' :
                if (this.previousDirection === DIRECTION_TOP_LEFT) {
                    this.nowDirection = DIRECTION_TOP_RIGHT;
                } else if (this.previousDirection === DIRECTION_DOWN_LEFT) {
                    this.nowDirection = DIRECTION_DOWN_RIGHT;
                }
                break;
            case 'touchTop' :
                if (this.previousDirection === DIRECTION_TOP_LEFT) {
                    this.nowDirection = DIRECTION_DOWN_LEFT;
                } else if (this.previousDirection === DIRECTION_TOP_RIGHT) {
                    this.nowDirection = DIRECTION_DOWN_RIGHT;
                }
                break;
            case 'touchBottom' :
                this.isOver = true;
                break;
        }
        this.nowAngleX = RANDOM_BALL_ANGLE_X;
        this.nowAngleY = RANDOM_BALL_ANGLE_Y;

    }

    playBall() {
        if (this.isOver === true) {
            return;
        }
        this.ball.move(this.nowDirection, this.nowAngleX, this.nowAngleY);
        this.check_get_direction_and_angle();
        this.render();
    }
    playBar (event) {
        if (this.isOver === true) {
            return;
        }
        switch (event.keyCode) {
            case 37 :
                if (this.bar.left > this.left) {
                    this.bar.moveLeft();
                }
                break;
            case 39 :
                if (this.bar.left + this.bar.width < this.left + this.width) {
                this.bar.moveRight();
                }
                break;
        }
    }
}
let gameBoard;
let ball;
let bar;
function startBouncingBall() {
    ball = new Ball(DEFAULT_BALL_SRC, DEFAULT_BALL_X_POSITION, DEFAULT_BALL_Y_POSITION,
                        DEFAULT_BALL_WIDTH, DEFAULT_BALL_HEIGHT);
    bar = new Bar(DEFAULT_BAR_SRC, DEFAULT_BAR_X_POSITION, DEFAULT_BAR_Y_POSITION,
                      DEFAULT_BAR_WIDTH, DEFAULT_BAR_HEIGHT, DEFAULT_BAR_DISTANCE);
    gameBoard = new GameBoard(DEFAULT_BOARD_X_POSITION, DEFAULT_BOARD_Y_POSITION,
                                  DEFAULT_BOARD_WIDTH, DEFAULT_BOARD_HEIGHT, ball, bar);
    gameBoard.start();
    gameBoard.setDefaultAngle(RANDOM_BALL_ANGLE_X,RANDOM_BALL_ANGLE_Y);
    gameBoard.setDefaultDirection(DIRECTION_TOP_RIGHT);
}
startBouncingBall();

function playBall() {
    gameBoard.playBall();
}
function playBar(event) {
    gameBoard.playBar(event);
}
function loadGame() {
    // check = gameBoard.isOver;
    if (gameBoard.isOver === false) {
        window.addEventListener('keydown',playBar);
        playBall();
        setTimeout(loadGame,20);
    } else {
        alert('Game Over');
    }
}

