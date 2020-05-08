
let listOfficers = [];

class Officer {
    constructor(name, birthday, address, salary, position) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.salary = salary;
        this.position = position;
    }

}

let inputName = document.getElementById('inputName');
let inputBirthday = document.getElementById('inputBirthday');
let inputAddress = document.getElementById('inputAddress');
let inputSalary = document.getElementById('inputSalary');
let inputPosition = document.getElementById('inputPosition');

class ManagerOfficer {

    add () {
        let name = inputName.value.trim();
        let birthday = inputBirthday.value.trim();
        let address = inputAddress.value.trim();
        let salary = inputSalary.value.trim();
        let position = inputPosition.value.trim();
        if (name === '' ||birthday === '' || address === ''|| salary === ''|| position === '') {
            alert('Input value can not be empty, please try again!')
        } else {
            let officer = new Officer(name,birthday,address,salary,position);
            listOfficers.push(officer);
            alert('Add success!');
        }
    }

    clear () {
        inputName.value = '';
        inputBirthday.value = '';
        inputAddress.value = '';
        inputSalary.value = '';
        inputPosition.value = '';
    }

    displayList () {
        let tempVar = '<table id="table1" border="1" cellspacing="0" width="800" ><tr><th>STT</th><th>Name</th><th>Birthday</th>' +
            '<th>Address</th><th>Salary</th><th>Position</th>';
        for (let i = 0 ; i < listOfficers.length;i++) {
            tempVar += '<tr>';
            for (let j = 0; j < 6; j++) {
                tempVar += '<td>';
                switch (j) {
                    case 0 :
                        tempVar +=  i + 1;
                        break;
                    case 1 :
                        tempVar += listOfficers[i].name;
                        break;
                    case 2 :
                        tempVar += listOfficers[i].birthday;
                        break;
                    case 3 :
                        tempVar += listOfficers[i].address;
                        break;
                    case 4 :
                        tempVar += listOfficers[i].salary;
                        break;
                    case 5 :
                        tempVar += listOfficers[i].position;
                        break;
                }
                tempVar += '</td>'
            }
            tempVar += '</tr>';
        }
        tempVar += '</table>';
        document.getElementById('div2').innerHTML = tempVar;
    }
}

let manager_officer = new ManagerOfficer();
let officer1 = new Officer('Nguyễn Văn B','08-11-1996','Quảng Nam',2000,'Lễ Tân');
let officer2 = new Officer('Nguyễn Văn A','09-11-1996','Đà Nẵng',3000,'Quản lý');
listOfficers.push(officer1,officer2);





