const BASIC_SALARY = 1490000;
const SALARY_RATE_1 = 4;
const SALARY_RATE_2 = 4.5;
const SALARY_RATE_3 = 5;
const SALARY_RATE_4 = 5.5;
const SALARY_RATE_5 = 6;
const SALARY_RATE_6 = 7;

let listOfficers = [];

class Officer {
    constructor(name, id, gender, native, birthday, position, level, startingDate, allowance) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.native = native;
        this.birthday = birthday;
        this.position = position;
        this.level = level;
        this.startingDate = startingDate;
        this.allowance = allowance;
    }

    getYearWorking() {
        let timeNow = new Date();
        let timeStartWorking = new Date(this.startingDate);
        return (timeNow.getTime() - timeStartWorking.getTime()) / (1000 * 60 * 60 * 24 * 30 * 12);
    }

    getSalaryRate() {
        switch (this.position.toLowerCase()) {
            case 'security' :
                if (this.getYearWorking() >= 1) {
                    return SALARY_RATE_2;
                }
                return  SALARY_RATE_1;
            case 'admin' :
                if (this.getYearWorking() >= 1) {
                    return  SALARY_RATE_3;
                }
                return  SALARY_RATE_4;
            case 'it' :
                if (this.getYearWorking() >= 1) {
                    return  SALARY_RATE_5;
                }
                    return  SALARY_RATE_6;
        }
    }

    getTotalSalary() {
        return BASIC_SALARY * this.getSalaryRate() + this.allowance;
    }

}

let inputName = document.getElementById('inputName');
let inputId = document.getElementById('inputId');
let inputGender = document.getElementById('inputGender');
let inputNative = document.getElementById('inputNative');
let inputBirthday = document.getElementById('inputBirthday');
let inputPosition = document.getElementById('inputPosition');
let inputLevel = document.getElementById('inputLevel');
let inputStartingDate= document.getElementById('inputStartingDate');
let inputAllowance = document.getElementById('inputAllowance');

class ManagerOfficer {

    add () {

        let name = inputName.value.trim();
        let id = inputId.value.trim();
        let gender = inputGender.value.trim();
        let native = inputNative.value.trim();
        let birthday = inputBirthday.value.trim();
        let position = inputPosition.value.trim();
        let level = inputLevel.value.trim();
        let startingDate = inputStartingDate.value.trim();
        let allowance = parseFloat(inputAllowance.value.trim());
        if (name === '' ||id === '' || gender === '' || native === '' || birthday === '' ||
            position === '' || level === '' || startingDate === '' || allowance === '') {
            alert('Input value can not be empty, please try again!')
        } else {
            let officer = new Officer(name,id,gender,native,birthday,position,level,startingDate,allowance);
            listOfficers.push(officer);
            alert('Add success!');
        }
    }

    clear () {
        inputName.value = '';
        inputId.value = '';
        inputGender.value = '';
        inputNative.value = '';
        inputBirthday.value = '';
        inputPosition.value = '';
        inputLevel.value = '';
        inputStartingDate.value = '';
        inputAllowance.value = '';
    }

    displayList () {
        let tempVar = '<table id="table1" border="1"  cellspacing="0" width="1200" ><tr><th>STT</th><th>Name</th><th>ID</th>' +
                      '<th>Gender</th><th>Native</th><th>Birthday</th><th>Position</th><th>Level</th>' +
                      '<th>Starting date</th><th>Total year working</th><th>Salary rate</th>' +
                      '<th>Allowance</th><th>Total salary</th></tr>';

        for (let i = 0 ; i < listOfficers.length;i++) {
            tempVar += '<tr>';
            for (let j = 0; j < 13; j++) {
                tempVar += '<td>';
                switch (j) {
                    case 0 :
                        tempVar +=  i + 1;
                        break;
                    case 1 :
                        tempVar += listOfficers[i].name;
                        break;
                    case 2 :
                        tempVar += listOfficers[i].id;
                        break;
                    case 3 :
                        tempVar += listOfficers[i].gender;
                        break;
                    case 4 :
                        tempVar += listOfficers[i].native;
                        break;
                    case 5 :
                        tempVar += listOfficers[i].birthday;
                        break;
                    case 6 :
                        tempVar += listOfficers[i].position;
                        break;
                    case 7 :
                        tempVar += listOfficers[i].level;
                        break;
                    case 8 :
                        tempVar += listOfficers[i].startingDate;
                        break;
                    case 9 :
                        tempVar += listOfficers[i].getYearWorking();
                        break;
                    case 10 :
                        tempVar += listOfficers[i].getSalaryRate();
                        break;
                    case 11 :
                        tempVar += listOfficers[i].allowance;
                        break;
                    case 12 :
                        tempVar += listOfficers[i].getTotalSalary();
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

