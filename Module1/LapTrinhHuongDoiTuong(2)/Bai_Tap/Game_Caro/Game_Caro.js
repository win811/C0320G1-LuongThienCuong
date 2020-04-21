
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
        document.writeln(tempDisplay);
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
        let a;
        let b;
        let c;
        let checkNotEmpty;
        let checkEqual;
        //Horizontal ( chiều ngang )
        for ( let i = 0 ; i < this.rows; i++) {
            for (let j = 0; j < this.cols; j++) {
                a = this.element(i+'-'+j).textContent;
                b = this.element(i+'-'+(j + 1)).textContent;
                c = this.element(i+'-'+(j + 2)).textContent;
                checkNotEmpty = a !== '' && b !== '' && c !== '';
                checkEqual = a === b && a === c;
                if (checkNotEmpty) {
                    if (checkEqual) {
                        alert(this.element(i+'-'+j).textContent + ' is Winner');
                        break;
                    }
                }
            }
            if (checkEqual) {
                break;
            }
        }
        if (checkEqual) {
            this.isOver = true;
            return;
        }
        // //Vertical (chiều dọc)
        // for (let j = 0; j <this.cols; j++) {
        //     for ( let i = 0; i < this.rows; i++) {
        //         a = this.element(i+'-'+j).textContent;
        //         b = this.element((i+1)+'-'+j).textContent;
        //         c = this.element((i+2)+'-'+j).textContent;
        //         checkNotEmpty = a !== '' && b !== '' && c !== '';
        //         checkEqual = a === b && a === c;
        //         if (checkNotEmpty) {
        //             if (checkEqual) {
        //                 alert(this.element(i+'-'+j).textContent + ' is Winner');
        //                 break;
        //             }
        //         }
        //     }
        //     if (checkEqual) {
        //         break;
        //     }
        // }
        // if (checkEqual) {
        //     this.isOver = true;
        //     return;
        // }
    }
}
let table1 = new Table(10,10);
table1.draw();
table1.setTurn();
function play(id) {
    table1.play(id)
}