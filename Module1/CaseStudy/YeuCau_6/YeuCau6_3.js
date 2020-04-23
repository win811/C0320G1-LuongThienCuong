
// Tạo function editInfoCustomer & deleteCustomer

function editPropertyCustomer(indexNameCustomer,indexPropertyCustomer) {
        let regExp;
        switch (indexPropertyCustomer) {
            case 0 :
                tempVar = prompt('Set a new Name').trim();
                regExp = /[0-9]/g;
                while (true) {
                    let result = tempVar.match(regExp);
                    if (result === null) {
                        break;
                    } else {
                        tempVar = prompt('Name must be word, please try again')
                    }
                }
                listCustomers[indexNameCustomer].setName(tempVar);
                break;
            case 1 :
                tempVar = prompt('Set a new Cmnd').trim();
                regExp = /^[0-9]{9}$/;
                while (true) {
                    if (checkFormat(regExp,tempVar)) {
                        break;
                    } else {
                        tempVar = prompt('Cmnd must have 9 numbers, please try again')
                    }
                }
                listCustomers[indexNameCustomer].setCmnd(tempVar);
                break;
            case 2 :
                tempVar = prompt('Set a new Birthday').trim();
                regExp = /^\d{2}[/]\d{2}[/]\d{4}$/;
                while (true) {
                    if (checkFormat(regExp,tempVar)) {
                        break;
                    } else {
                        tempVar = prompt('Birthday must follow the format : dd/mm/yyyy , please try again')
                    }
                }
                listCustomers[indexNameCustomer].setBirthday(tempVar);
                break;
            case 3 :
                tempVar = prompt('Set a new Email');
                regExp = /^[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+$/;
                while (true) {
                    if (checkFormat(regExp,tempVar)) {
                        break;
                    } else {
                        tempVar = prompt('Email must follow the format : abc@abc.com  , please try again')
                    }
                }
                listCustomers[indexNameCustomer].setEmail(tempVar);
                break;
            case 4 :
                tempVar = prompt('Set a new Address').trim();
                listCustomers[indexNameCustomer].setAddress(tempVar);
                break;
            case 5 :
                tempVar = prompt('Set a new customer type').trim();
                while (true) {
                    if (tempVar.toLowerCase() === 'diamond' ||tempVar.toLowerCase() === 'platinum'||
                        tempVar.toLowerCase() === 'gold'||tempVar.toLowerCase() === 'silver'||
                        tempVar.toLowerCase() === 'member') {
                        break;
                    } else {
                        tempVar = prompt('Customer type must be "Diamond" or "Platinum" or "Gold" or "Silver" or "Member", please try again')
                    }
                }
                listCustomers[indexNameCustomer].setType(tempVar);
                break;
            case 6 :
                tempVar = parseFloat(prompt('Set a new discount'));
                while (true) {
                    if (tempVar <= 100) {
                        break;
                    } else {
                        tempVar = prompt('Discount must be lower than or equal 100, please try again')
                    }
                }
                listCustomers[indexNameCustomer].setDiscount(tempVar);
                break;
            case 7 :
                tempVar = prompt('Set a new service type').trim();
                while (true) {
                    if (tempVar.toLowerCase() === 'villa' || tempVar.toLowerCase() === 'house' || tempVar.toLowerCase() === 'room') {
                        break;
                    } else {
                        tempVar = prompt('Service type must be "villa" or "house" or "room", please try again');
                    }
                }
                listCustomers[indexNameCustomer].setServiceType(tempVar);
                break;
            case 8 :
                tempVar = prompt('Set a new room type').trim();
                while (true) {
                    if (tempVar.toLowerCase() === 'vip' ||tempVar.toLowerCase() === 'business' || tempVar.toLowerCase() === 'normal') {
                        break;
                    } else {
                        tempVar = prompt('Room type must be "vip" or "business" or "normal", please try again');
                    }
                }
                listCustomers[indexNameCustomer].setRoomType(tempVar);
                break;
            case 9 :
                tempVar = parseFloat(prompt('Set a new rent days'));
                while (true) {
                    if (tempVar > 0) {
                        break;
                    } else {
                        tempVar = parseFloat(prompt('Rent days must be higher than 0, please try again'));
                    }
                }
                listCustomers[indexNameCustomer].setRentDays(tempVar);
                break;
            case 10 :
                tempVar = parseInt(prompt('Set a new amount'));
                while (true) {
                    if (Number.isInteger(tempVar) && tempVar > 0) {
                        break;
                    } else {
                        tempVar = parseInt(prompt('Amount must be integer and higher than 0, please try again'));
                    }
                }
                listCustomers[indexNameCustomer].setAmount(tempVar);
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

