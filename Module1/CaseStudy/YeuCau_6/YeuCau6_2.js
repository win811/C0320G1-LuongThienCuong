//Tạo function displayInfoCustomer & displayTotalPayCustomer & displaySalaryEmployee

let tempVar;
function getNameList(arrList) {
    tempVar = '';
    for (let i = 0; i < arrList.length; i++) {
        tempVar += i + '. ' + arrList[i].getName() + '\n';
    }
}

function getInfoCustomer(indexNameCustomer) {
    tempVar = '';
    for (let i = 0; i < 11; i++) {
        switch (i) {
            case 0 :
                tempVar += i + '. Name : ' + listCustomers[indexNameCustomer].getName() + '\n';
                break;
            case 1 :
                tempVar += i + '. Cmnd : ' + listCustomers[indexNameCustomer].getCmnd() + '\n';
                break;
            case 2 :
                tempVar += i + '. Birthday : ' + listCustomers[indexNameCustomer].getBirthday() + '\n';
                break;
            case 3 :
                tempVar += i + '. Email : ' + listCustomers[indexNameCustomer].getEmail() + '\n';
                break;
            case 4 :
                tempVar += i + '. Address : ' + listCustomers[indexNameCustomer].getAddress() + '\n';
                break;
            case 5 :
                tempVar += i + '. Customer Type : ' + listCustomers[indexNameCustomer].getType() + '\n';
                break;
            case 6 :
                tempVar += i + '. Discount : ' + listCustomers[indexNameCustomer].getDiscount() + '\n';
                break;
            case 7 :
                tempVar += i + '. Service Type : ' + listCustomers[indexNameCustomer].getServiceType() + '\n';
                break;
            case 8 :
                tempVar += i + '. Room Type : ' + listCustomers[indexNameCustomer].getRoomType() + '\n';
                break;
            case 9 :
                tempVar += i + '. Rent Days : ' + listCustomers[indexNameCustomer].getRentDays() + '\n';
                break;
            case 10 :
                tempVar += i + '. Amount : ' + listCustomers[indexNameCustomer].getAmount() + '\n';
        }
    }
}

function displayInfoCustomer() {
    getNameList(listCustomers);
    let indexNameCustomer = parseInt(prompt('Input index (select customer you want to display)' + '\n' + tempVar));
    getInfoCustomer(indexNameCustomer);
    alert('Information of ' + listCustomers[indexNameCustomer].getName() + ' : ' + '\n' + tempVar);
}

function displayTotalPayCustomer() {
    getNameList(listCustomers);
    let indexNameCustomer = parseInt(prompt('Input index (select customer you want to calculate total pay)' + '\n' + tempVar));
    getInfoCustomer(indexNameCustomer);
    alert(  'Total pay of ' + listCustomers[indexNameCustomer].getName() + ' : ' + '\n' + tempVar + '\n' +
        '=> Total pay is : ' + listCustomers[indexNameCustomer].getTotalPay() + '$');
}

function displaySalaryEmployee() {
    getNameList(listEmployee);
    let indexNameEmployee = parseInt(prompt('Input index (select employee you want to calculate total salary)' + '\n' + tempVar));
    alert('Total salary of ' + listEmployee[indexNameEmployee].getName() + ' : ' + listEmployee[indexNameEmployee].getSalary() + '$');
}


// Tạo function editInfoCustomer & deleteCustomer

function editPropertyCustomer(indexNameCustomer,indexPropertyCustomer) {
    switch (indexPropertyCustomer) {
        case 0 :
            let name = input_check_return_name_();
            listCustomers[indexNameCustomer].setName(name);
            break;
        case 1 :
            let cmnd = input_check_return_cmnd();
            listCustomers[indexNameCustomer].setCmnd(cmnd);
            break;
        case 2 :
            let birthday = input_check_return_birthday();
            listCustomers[indexNameCustomer].setBirthday(birthday);
            break;
        case 3 :
            let email = input_check_return_email();
            listCustomers[indexNameCustomer].setEmail(email);
            break;
        case 4 :
            let address = input_check_return_address();
            listCustomers[indexNameCustomer].setAddress(address);
            break;
        case 5 :
            let customerType = input_check_return_customerType();
            listCustomers[indexNameCustomer].setType(customerType);
            break;
        case 6 :
            let discount = input_check_return_discount();
            listCustomers[indexNameCustomer].setDiscount(discount);
            break;
        case 7 :
            let serviceType = input_check_return_serviceType();
            listCustomers[indexNameCustomer].setServiceType(serviceType);
            break;
        case 8 :
            let roomType = input_check_return_roomType();
            listCustomers[indexNameCustomer].setRoomType(roomType);
            break;
        case 9 :
            let rentDays = input_check_return_rentDays();
            listCustomers[indexNameCustomer].setRentDays(rentDays);
            break;
        case 10 :
            let amount = input_check_return_amount();
            listCustomers[indexNameCustomer].setAmount(amount);
    }
}
function editInforCustomer() {
    getNameList(listCustomers);
    let indexNameCustomer = parseInt(prompt('Input index (select customer you want to edit)' + '\n' + tempVar));
    getInfoCustomer(indexNameCustomer);
    let indexPropertyCustomer = parseInt(prompt('Input index (select property you want to edit)' + '\n' + tempVar));
    editPropertyCustomer(indexNameCustomer,indexPropertyCustomer);
    getInfoCustomer(indexNameCustomer);
    alert('Information of ' + listCustomers[indexNameCustomer].getName() + ' : ' + '\n' + tempVar);
}

function deleteCustomer() {
    getNameList(listCustomers);
    let indexNameCustomer = parseInt(prompt('Input index ( select customer you want to delete)'+ '\n' + tempVar));
    for (let i = indexNameCustomer; i < listCustomers.length;i++ ) {
        if (i === listCustomers.length - 1 ) {
            listCustomers.pop();
        } else {
            listCustomers[i] = listCustomers[i+1];
        }
    }
    getNameList(listCustomers);
    alert('New list : ' + '\n' + tempVar);
}
