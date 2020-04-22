
//Tạo function displayInfoCustomer

let tempVar;
function showNameListCustomers() {
    tempVar = '';
    for (let i = 0; i < listCustomers.length; i++) {
        tempVar += i + '. ' + listCustomers[i].getName() + '\n';
    }
}
function showInfoCustomer(indexNameCustomer) {
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
    alert('Information of ' + listCustomers[indexNameCustomer].getName() + ' : ' + '\n' + tempVar);
}

function displayInfoCustomer() {
    showNameListCustomers();
    let indexNameCustomer = parseInt(prompt('Input index (select customer you want to display)' + '\n' + tempVar));
    showInfoCustomer(indexNameCustomer);
}