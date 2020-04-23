
// Tạo class Customer và function addNewCustomer

let listCustomers = [];
let listEmployee = [];
class Customer {
    constructor(name,cmnd,birthday,email,address,customerType,discount,serviceType,roomType,rentDays,amount) {
        this.name = name;
        this.cmnd = cmnd;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.discount = discount;
        this.serviceType = serviceType;
        this.roomType = roomType;
        this.rentDays = rentDays;
        this.amount = amount;
    }
    getName () {
        return this.name;
    }
    setName (newName) {
        this.name = newName;
    }
    getCmnd () {
        return this.cmnd;
    }
    setCmnd (newCmnd) {
        this.cmnd = newCmnd;

    }
    getBirthday () {
        return this.birthday;
    }
    setBirthday (newBirthday) {
        this.birthday = newBirthday;
    }
    getEmail () {
        return this.email;
    }
    setEmail (newEmail) {
        this.email = newEmail;
    }
    getAddress () {
        return this.address;
    }
    setAddress (newAddress) {
        this.address = newAddress;
    }
    getType () {
        return this.customerType;
    }
    setType (newCustomerType) {
        this.customerType = newCustomerType;
    }
    getDiscount() {
        return this.discount;
    }
    setDiscount (newDiscount) {
        this.discount = newDiscount;
    }
    getServiceType () {
        return this.serviceType;
    }
    setServiceType (newServiceType) {
        this.serviceType = newServiceType;
    }
    getRoomType () {
        return this.roomType;
    }
    setRoomType (newRoomType) {
        this.roomType = newRoomType;
    }
    getRentDays () {
        return this.rentDays;
    }
    setRentDays (newRentDays) {
        this.rentDays = newRentDays;
    }
    getAmount () {
        return this.amount;
    }
    setAmount (newAmount) {
        this.amount = newAmount;
    }
    getTotalPay () {
        let totalPay;
        let villaPrice = 500;
        let housePrice = 300;
        let roomPrice = 100;
        if (this.serviceType.toLowerCase() === 'villa') {
            totalPay = villaPrice*this.rentDays*this.amount*(1-this.discount/100);
            return totalPay;
        } else if (this.serviceType.toLowerCase() === 'house') {
            totalPay = housePrice*this.rentDays*this.amount*(1-this.discount/100);
            return totalPay;
        } else {
            totalPay = roomPrice*this.rentDays*this.amount*(1-this.discount/100);
            return totalPay;
        }
    }
}

class Employee extends Customer{
    constructor(name,cmnd,birthday,email,phoneNumber,level,position,department,salary) {
        super (name,cmnd,birthday,email);
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }
    getSalary () {
        switch (this.department.toLowerCase()) {
            case 'manager' :
                this.salary += 500;
                break;
            case 'sale' :
                this.salary += 300;
                break;
            case 'marketing' :
                this.salary += 200;
                break;
        }
        return this.salary;
    }

}

function checkFormat(regExp,value) {
    if (regExp.test(value)) {
        return true;
    }
    return false;
}

function addNewCustomer() {
    let regExp;

    let name=(prompt('Input Name')).trim();
    regExp = /[0-9]/g;
    while (true) {
        let result = name.match(regExp);
        if (result === null) {
            break;
        } else {
            name = prompt('Name must be word, please try again')
        }
    }

    let cmnd=prompt('Input cmnd').trim();
    regExp = /^[0-9]{9}$/;
    while (true) {
        if (checkFormat(regExp,cmnd)) {
            break;
        } else {
            cmnd = prompt('Cmnd must have 9 numbers, please try again')
        }
    }

    let birthday=prompt('Input Birthday').trim();
    regExp = /^\d{2}[/]\d{2}[/]\d{4}$/;
    while (true) {
        if (checkFormat(regExp,birthday)) {
            break;
        } else {
            birthday = prompt('Birthday must follow the format : "dd/mm/yyyy" , please try again')
        }
    }

    let email=prompt('Input Email').trim();
    regExp = /^[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+$/;
    while (true) {
        if (checkFormat(regExp,email)) {
            break;
        } else {
            email = prompt('Email must follow the format : "abc@abc.com"  , please try again')
        }
    }

    let address=prompt('Input Address').trim();

    let customerType=prompt('Input Customer Type').trim();
    while (true) {
        if (customerType.toLowerCase() === 'diamond' ||customerType.toLowerCase() === 'platinum'||
            customerType.toLowerCase() === 'gold'||customerType.toLowerCase() === 'silver'||
            customerType.toLowerCase() === 'member') {
            break;
        } else {
            customerType = prompt('Customer type must be "Diamond" or "Platinum" or "Gold" or "Silver" or "Member", please try again')
        }
    }

    let discount=parseFloat(prompt('Input Discount'));
    while (true) {
        if (discount <= 100) {
            break;
        } else {
            discount = parseFloat(prompt('Discount must be lower than or equal 100, please try again'))
        }
    }

    let serviceType=prompt('Input Service Type').trim();
    while (true) {
        if (serviceType.toLowerCase() === 'villa' || serviceType.toLowerCase() === 'house' || serviceType.toLowerCase() === 'room') {
            break;
        } else {
            serviceType = prompt('Service type must be "villa" or "house" or "room", please try again');
        }
    }

    let roomType=prompt('Input Room Type');
    while (true) {
        if (roomType.toLowerCase() === 'vip' || roomType.toLowerCase() === 'business' || roomType.toLowerCase() === 'normal') {
            break;
        } else {
            roomType = prompt('Room type must be "vip" or "business" or "normal", please try again');
        }
    }

    let rentDays=parseFloat(prompt('Input Rent Days'));
    while (true) {
        if (rentDays > 0) {
            break;
        } else {
            rentDays = parseFloat(prompt('Rent days must be higher than 0, please try again'));
        }
    }

    let amount=parseInt(prompt('Input Amount'));
    while (true) {
        if (Number.isInteger(amount) && amount > 0) {
            break;
        } else {
            amount = parseInt(prompt('Amount must be integer and higher than 0, please try again'));
        }
    }

    let customer = new Customer(name,cmnd,birthday,email,address,customerType,discount,serviceType,roomType,rentDays,amount);
    listCustomers.push(customer);
}

function addNewEmployee() {
    let regExp;

    let name=(prompt('Input Name')).trim();
    regExp = /[0-9]/g;
    while (true) {
        let result = name.match(regExp);
        if (result === null) {
            break;
        } else {
            name = prompt('Name must be word, please try again')
        }
    }

    let cmnd=prompt('Input cmnd').trim();
    regExp = /^[0-9]{9}$/;
    while (true) {
        if (checkFormat(regExp,cmnd)) {
            break;
        } else {
            cmnd = prompt('Cmnd must have 9 numbers, please try again')
        }
    }

    let birthday=prompt('Input Birthday').trim();
    regExp = /^\d{2}[/]\d{2}[/]\d{4}$/;
    while (true) {
        if (checkFormat(regExp,birthday)) {
            break;
        } else {
            birthday = prompt('Birthday must follow the format : "dd/mm/yyyy" , please try again')
        }
    }

    let email=prompt('Input Email').trim();
    regExp = /^[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+$/;
    while (true) {
        if (checkFormat(regExp,email)) {
            break;
        } else {
            email = prompt('Email must follow the format : "abc@abc.com"  , please try again')
        }
    }

    let phoneNumber = prompt('Input phone number').trim();
    regExp = /^[0][0-9]{9}$/;
    while (true) {
        if (checkFormat(regExp,phoneNumber)) {
            break;
        } else {
            phoneNumber = prompt('Phone number must follow the format : "0xxxxxxxxx"  , please try again')
        }
    }

    let level = prompt('Input certificate').trim();
    while (true) {
        let tempVar = level.toLowerCase();
        if (tempVar === 'intermediate'||tempVar === 'college'||tempVar === 'university'||tempVar === 'graduate') {
            break;
        } else {
            email = prompt('This level is not qualified for the job, level must be "intermediate" or' +
                                    '"college" or "university" or "graduate" , please try again')
        }
    }

    let position = prompt('Input position').trim();

    let department = prompt('Input department').trim();
    while (true) {
        let tempVar = department.toLowerCase();
        if (tempVar === 'sale'||tempVar === 'marketing'||tempVar === 'admin'||tempVar === 'monitor'||
            tempVar === 'manager'||tempVar === 'director') {
            break;
        } else {
            email = prompt('Department must be "sale" or "marketing" or "admin" or "monitor" ' +
                                    'or "manager" or "director" , please try again')
        }
    }

    let salary = parseFloat(prompt('Input salary'));
    while (true) {
        if (Number.isNaN(salary) === false) {
            break;
        } else {
            salary = prompt('Salary must be a number')
        }
    }

    let employee = new Employee(name,cmnd,birthday,email,phoneNumber,level,position,department,salary);
    listEmployee.push(employee);
}
