
class Table {
    constructor(rows,cols) {
        this.rows = rows;
        this.cols = cols;
    }
    draw () {
        let tempDisplay = '<table id="table" border="0" cellspacing="0">';
        for ( let i = 0 ; i < this.rows; i++) {
            tempDisplay += '<tr>';
            for (let j = 0 ; j < this.cols; j++) {
                tempDisplay += '<td class = "cell" id="'+ i +'-'+ j + '" width="40" height="40" onclick="play(this)"></td>'
            }
            tempDisplay += '</tr>';
        }
        tempDisplay += '</table>';
        document.getElementById('display').innerHTML = tempDisplay;
    }

    setTurn () {
        this.turn = 0;
        this.isOver = false;
    }

    play (id) {
        if (this.isOver) {
            return;
        }
        if (id.textContent === '') {
            if (this.turn === 0 || this.turn === 2) {
                id.textContent = 'X';
                this.turn = 1;
            } else if (this.turn === 1) {
                id.textContent = 'O';
                this.turn = 2;
            }
        } else {
            alert('Cell is already marked');
        }
        this.checkWinner();
    }

    element (id) {
        return document.getElementById(id);
    }

    checkWinner () {
        let cell1;
        let cell2;
        let cell3;
        let checkNotEmpty;
        let checkEqual;
        let tempOver = false;
        function checkTotal() {
            checkNotEmpty = cell1 !== '' && cell2 !== '' && cell3 !== '';
            checkEqual = cell1 === cell2 && cell1 === cell3;
            if (checkNotEmpty) {
                if (checkEqual) {
                    tempOver = true;
                }
            }
        }

        //Horizontal ( chiều ngang )
        for ( let i = 0 ; i < this.rows; i++) {
            for (let j = 0; j < this.cols-2; j++) {
                cell1 = (this.element(i+'-'+j)).textContent;
                cell2 = (this.element(i+'-'+(j + 1))).textContent;
                cell3 = (this.element(i+'-'+(j + 2))).textContent;
                checkTotal();
                this.isOver = tempOver;
                if (this.isOver) {
                    alert(this.element(i+'-'+j).textContent + ' is Winner');
                    return;
                }
            }
        }
        // Vertical (chiều dọc)
        for ( let i = 0 ; i < this.rows-2; i++) {
            for ( let j = 0; j < this.cols; j++) {
                cell1 = this.element(i+'-'+j).textContent;
                cell2 = this.element((i+1)+'-'+j).textContent;
                cell3 = this.element((i+2)+'-'+j).textContent;
                checkTotal();
                this.isOver = tempOver;
                if (this.isOver) {
                    alert(this.element(i+'-'+j).textContent + ' is Winner');
                    return;
                }
            }
        }
        //Left diagonal (chéo trái)
        for ( let i = 0 ; i < this.rows-2; i++) {
            for ( let j = 0; j < this.cols-2; j++) {
                cell1 = this.element(i+'-'+j).textContent;
                cell2 = this.element((i+1)+'-'+(j+1)).textContent;
                cell3 = this.element((i+2)+'-'+(j+2)).textContent;
                checkTotal();
                this.isOver = tempOver;
                if (this.isOver) {
                    alert(this.element(i+'-'+j).textContent + ' is Winner');
                    return;
                }
            }
        }
        //Right diagonal (chéo phải)
        for ( let i = 0 ; i < this.rows -2 ; i++) {
            for ( let j = this.cols - 1 ; j > 1; j--) {
                cell1 = this.element(i+'-'+j).textContent;
                cell2 = this.element((i+1)+'-'+(j-1)).textContent;
                cell3 = this.element((i+2)+'-'+(j-2)).textContent;
                checkTotal();
                this.isOver = tempOver;
                if (this.isOver) {
                    alert(this.element(i+'-'+j).textContent + ' is Winner');
                    return;
                }
            }
        }
    }
}

let table1;
function start () {
    table1 = new Table(10, 10);
    table1.draw();
    table1.setTurn();
}
function play(id) {
    table1.play(id)
}
start();
