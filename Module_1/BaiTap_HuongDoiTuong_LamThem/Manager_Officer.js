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
        let totalYears = (timeNow.getTime() - timeStartWorking.getTime()) / (1000 * 60 * 60 * 24 * 30 * 12);
        return totalYears.toFixed(4);
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
                    return  SALARY_RATE_4;
                }
                return  SALARY_RATE_3;
            case 'it' :
                if (this.getYearWorking() >= 1) {
                    return  SALARY_RATE_6;
                }
                    return  SALARY_RATE_5;
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
        let startingDate = inputStartingDate.value.trim(); // Nhớ nhập theo định dạng string date
        let allowance = (inputAllowance.value.trim());
        if (name === '' ||id === '' || gender === '' || native === '' || birthday === '' ||
            position === '' || level === '' || startingDate === '' || allowance === '') {
            alert('Input value can not be empty, please try again!')
        } else {
            let officer = new Officer(name,id,gender,native,birthday,position,level,startingDate,parseFloat(allowance));
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

    getTotalSalaryOfCompany () {
        let total = 0;
        for (let i = 0; i < listOfficers.length; i++ ) {
            total += listOfficers[i].getTotalSalary();
        }
        return total;
    }

    displayList () {
        let tempVar = '<table id="table1" border="1" cellspacing="0" width="1200" ><tr><th>STT</th><th>Name</th><th>ID</th>' +
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
                        tempVar += listOfficers[i].allowance.toLocaleString();
                        break;
                    case 12 :
                        tempVar += listOfficers[i].getTotalSalary().toLocaleString();
                        break;
                }
                tempVar += '</td>'
            }
            tempVar += '</tr>';
        }
        tempVar += '<th colspan="12">TOTAL SALARY OF COMPANY</th><td>' + this.getTotalSalaryOfCompany().toLocaleString() + '</td>';
        tempVar += '</table>';
        document.getElementById('div2').innerHTML = tempVar;
    }
}

let manager_officer = new ManagerOfficer();
let officer1 = new Officer('Nguyễn Văn A','001','Male','Đà Nẵng','07-12-1960',
                         'Security','High School','2017-5-25',300000);
let officer2 = new Officer('Lương Thiên Cường','002','Male','Đà Nẵng','08-11-1996',
                         'IT','University','2019-4-20',500000);
listOfficers.push(officer1,officer2);


