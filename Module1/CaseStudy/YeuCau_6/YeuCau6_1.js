
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
        } else if (this.serviceType.toLowerCase() === 'house') {
            totalPay = housePrice*this.rentDays*this.amount*(1-this.discount/100);
        } else {
            totalPay = roomPrice*this.rentDays*this.amount*(1-this.discount/100);
        }
        return totalPay;
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

function input_check_return_name_() {
    let name=(prompt('Input Name')).trim();
    let regExp = /[0-9]/g;
    while (true) {
        let result = name.match(regExp);
        if (result === null) {
            break;
        } else {
            name = prompt('Name must be word, please try again')
        }
    }
    return name;
}

function input_check_return_cmnd() {
    let cmnd=prompt('Input cmnd').trim();
    let regExp = /^[0-9]{9}$/;
    while (true) {
        if (regExp.test(cmnd)) {
            break;
        } else {
            cmnd = prompt('Cmnd must have 9 numbers, please try again')
        }
    }
    return cmnd;
}

function input_check_return_birthday() {
    let birthday=prompt('Input Birthday').trim();
    let regExp = /^\d{2}[/]\d{2}[/]\d{4}$/;
    while (true) {
        if (regExp.test(birthday)) {
            break;
        } else {
            birthday = prompt('Birthday must follow the format : "dd/mm/yyyy" , please try again')
        }
    }
    return birthday;
}

function input_check_return_email() {
    let email=prompt('Input Email').trim();
    let regExp = /^[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+$/;
    while (true) {
        if (regExp.test(email)) {
            break;
        } else {
            email = prompt('Email must follow the format : "abc@abc.com"  , please try again')
        }
    }
    return email;
}

function input_check_return_address() {
    return prompt('Input Address').trim();
}

function input_check_return_customerType() {
    let customerType= prompt('Input Customer Type').trim();
    let temp = customerType.toLowerCase();
    while (true) {
        if (temp === 'diamond' ||temp === 'platinum'|| temp === 'gold'||temp === 'silver'|| temp === 'member') {
            break;
        } else {
            customerType = prompt('Customer type must be "Diamond" or "Platinum" ' +
                                            'or "Gold" or "Silver" or "Member", please try again')
        }
    }
    return customerType;
}

function input_check_return_discount() {
    let discount = parseFloat(prompt('Input Discount'));
    while (true) {
        if (discount <= 100) {
            break;
        } else {
            discount = parseFloat(prompt('Discount must be lower than or equal 100, please try again'))
        }
    }
    return discount;
}

function input_check_return_serviceType() {
    let serviceType = prompt('Input Service Type').trim();
    let temp = serviceType.toLowerCase();
    while (true) {
        if (temp === 'villa' || temp === 'house' || temp === 'room') {
            break;
        } else {
            serviceType = prompt('Service type must be "villa" or "house" or "room", please try again');
        }
    }
    return serviceType;
}

function input_check_return_roomType() {
    let roomType=prompt('Input Room Type');
    let temp = roomType.toLowerCase();
    while (true) {
        if (temp === 'vip' || temp === 'business' || temp === 'normal') {
            break;
        } else {
            roomType = prompt('Room type must be "vip" or "business" or "normal", please try again');
        }
    }
    return roomType;
}

function input_check_return_rentDays() {
    let rentDays = parseFloat(prompt('Input Rent Days'));
    while (true) {
        if (rentDays > 0) {
            break;
        } else {
            rentDays = parseFloat(prompt('Rent days must be higher than 0, please try again'));
        }
    }
    return rentDays;
}

function input_check_return_amount() {
    let amount = parseInt(prompt('Input Amount'));
    while (true) {
        if (Number.isInteger(amount) && amount > 0) {
            break;
        } else {
            amount = parseInt(prompt('Amount must be integer and higher than 0, please try again'));
        }
    }
    return amount;
}

function input_check_return_phoneNumber() {
    let phoneNumber = prompt('Input phone number').trim();
    let regExp = /^[0][0-9]{9}$/;
    while (true) {
        if (regExp.test(phoneNumber)) {
            break;
        } else {
            phoneNumber = prompt('Phone number must follow the format : "0xxxxxxxxx"  , please try again')
        }
    }
    return phoneNumber;
}

function input_check_return_level() {
    let level = prompt('Input certificate').trim();
    let temp = level.toLowerCase();
    while (true) {
        if (temp === 'intermediate'||temp === 'college'||temp === 'university'||temp === 'graduate') {
            break;
        } else {
            level = prompt('This level is not qualified for the job, level must be "intermediate" or' +
                                    '"college" or "university" or "graduate" , please try again')
        }
    }
    return level;
}

function input_check_return_position() {
    let position = prompt('Input position').trim();
    let temp = position.toLowerCase();
    while (true) {
        if (temp === 'receptionist'||temp === 'waiter'||temp === 'waitress' ||temp === 'specialist'||temp === 'monitor'||
            temp === 'manager'||temp === 'director') {
            break;
        } else {
            email = prompt('Position must be "receptionist" or "waiter" or "waitress" or' +
                                    ' "specialist" or "monitor" or "manager" or "director" , please try again')
        }
    }
    return position;
}

function input_check_return_department() {
    let department = prompt('Input department').trim();
    let temp = department.toLowerCase();
    while (true) {
        if (temp === 'sale'||temp === 'marketing'||tempVar === ''||tempVar === 'admin'||
            tempVar === 'service'||tempVar === 'management') {
            break;
        } else {
            email = prompt('Department must be "sale" or "marketing" or "admin" or ' +
                                    '"service" or "management ", please try again')
        }
    }
    return department;
}

function input_check_return_salary() {
    let salary = parseFloat(prompt('Input salary'));
    while (true) {
        if (Number.isNaN(salary) === false) {
            break;
        } else {
            salary = prompt('Salary must be a number')
        }
    }
    return salary;
}

function addNewCustomer() {
    
    let name = input_check_return_name_();
    let cmnd = input_check_return_cmnd();
    let birthday = input_check_return_birthday();
    let email = input_check_return_email();
    let address = input_check_return_address();
    let customerType = input_check_return_customerType();
    let discount = input_check_return_discount();
    let serviceType = input_check_return_serviceType();
    let roomType = input_check_return_roomType();
    let rentDays = input_check_return_rentDays();
    let amount = input_check_return_amount();

    let customer = new Customer(name,cmnd,birthday,email,address,customerType,discount,serviceType,roomType,rentDays,amount);
    listCustomers.push(customer);

}

function addNewEmployee() {
    
    let name = input_check_return_name_();
    let cmnd = input_check_return_cmnd();
    let birthday = input_check_return_birthday();
    let email = input_check_return_email();
    let phoneNumber = input_check_return_phoneNumber();
    let level = input_check_return_level();
    let position = input_check_return_position();
    let department = input_check_return_department();
    let salary = input_check_return_salary();

    let employee = new Employee(name,cmnd,birthday,email,phoneNumber,level,position,department,salary);
    listEmployee.push(employee);

}
