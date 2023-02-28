const tableId = document.getElementById("tables");
const menuId = document.getElementById("menu-items");


//Initializing the app
const populate=()=> {
		sessionStorage.setItem("tables", JSON.stringify(tables));
	showTables();
	showMenu();
}

//Creating a table
const createTable=(id, cost, items)=> {
	let table = `<li onclick="openBox('table${id}')" ondrop="drop(event,'table${id}')" ondragover="allowDrop(event)" class="box1">
        <h2>Table-${id}</h2>
        <p>Rs ${cost} | Total items: ${items}</p>
        </li>`;

	return table;
}

//Showing tables
const showTables=()=> {
	let i = 1;
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	tableId.innerHTML = "";
	while (tables["table" + i] != null) {
		let { cost, items } = tables["table" + i];

		let table = createTable(i, cost, items);
		// console.log(table);
		tableId.insertAdjacentHTML("beforeend", table);
		i++;
	}
}

//Creating menu items
const createMenuItem=(i, name, cost, category)=> {
	let item = `<li id="item${i}" draggable="true" ondragstart="drag(event)">
		<div class="menu_items">
        <h3>${name}</h3>
        <p id="category">${category}</p>
        <p>${cost}.00</p>
		</div>
        </li>
        `;
	return item;
}

//Showing menu
const showMenu=()=> {
	let i = 1;
	menuId.innerHTML = "";
	while (menu["item" + i] != null) {
		let { name, cost, category } = menu["item" + i];
		let item = createMenuItem(i, name, cost, category);
		menuId.insertAdjacentHTML("beforeend", item);
		i++;
	}
}
function searchTable() {
	let searchKey = document.getElementById("table-search").value;
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	// console.log(searchKey);

	searchKey = searchKey.toLowerCase();

	let table = searchKey.split("-");

	if (tables[table[0] + table[1]] != null) {
		let { cost, items } = tables[table[0] + table[1]];
		tableId.innerHTML = "";

		let tableSearched = createTable(table[1], cost, items);

		tableId.insertAdjacentHTML("beforeend", tableSearched);
	} else {
		tableId.innerHTML = "";
		showTables();
	}
}


//Search from tables
/*const searchTable=()=> {
	let searchKey = document.getElementById("table-search").value;
	//console.log(searchKey);

	if (searchKey == "") {
		showTables();
		return;
	}
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	//console.log(tables);
	
	searchKey = searchKey.toLowerCase();
	//console.log(searchKey);


	//console.log(typeof(searchKey));
	let table = searchKey.split("-");

	//console.log(tables["table1"].cost);
	//console.log(tables[table[0]]);
	//console.log(table);

	
	let i=1;
	tableId.innerHTML=" ";

	while(tables["table"+i]!=null)
	{
		let {name, cost, items  } = tables["table"+i];
		let tname = name.toLowerCase();
		console.log(tables["table"+i].name);
		// let tablename = name;
		
		if(tname.includes(searchKey))
		{

		console.log(name);
		console.log(cost);
		
		let tableSearched = createTable(i, cost, items);

		tableId.insertAdjacentHTML("beforeend", tableSearched);
		}
		i++;
	}
}*/
// function searchTable() {
// 	let searchKey = document.getElementById("table-search").value;
// 	let tables = JSON.parse(sessionStorage.getItem("tables"));
// 	// console.log(searchKey);

// 	searchKey = searchKey.toLowerCase();

// 	let table = searchKey.split("-");

// 	if (tables[table[0] + table[1]] != null) {
// 		let { cost, items } = tables[table[0] + table[1]];
// 		tableId.innerHTML = "";

// 		let tableSearched = createTable(table[1], cost, items);

// 		tableId.insertAdjacentHTML("beforeend", tableSearched);
// 	} else {
// 		tableId.innerHTML = "";
// 		showTables();
// 	}
// }

//Search from menu
const searchMenu=()=> {
	let searchKey = document.getElementById("menu-search").value;
	searchKey = searchKey.toLowerCase();

	let i = 1;

	if (searchKey == "") {
		showMenu();
		return;
	}

	menuId.innerHTML = "";

	while (menu["item" + i] != null) {
		let { name, cost, category } = menu["item" + i];
		let itemName = name.toLowerCase();
		let itemCategory = category.toLowerCase();

		if (itemName.includes(searchKey) || itemCategory.includes(searchKey)) {
			let item = createMenuItem(i, name, cost, category);
			menuId.insertAdjacentHTML("beforeend", item);
		}
		i++;
	}
}

var modal = document.getElementById("myModal");

//Modal close
function closeModal() {
	modal.style.display = "none";
}

//clicking on modal




// Adding content to Modal
function openBox(tableNo) {
	console.log(tableNo);

	let box = document.querySelectorAll('.box1');
for (let i = 0; i < box.length; i++) {
  box[i].addEventListener('click', function() {
    // Change the background color of the clicked table to yellow
    this.style.backgroundColor = 'orange';
  });
}

	modal.style.display = "block";
	document.getElementById("modal-header").innerHTML = `
	<h3>${tableNo.toUpperCase()} | Order Details</h3>
	<span class="close" onclick="closeModal()">&times;</span>
	`;

	let rows = document.getElementById("rows");
	rows.innerHTML = `<tr>
	<th>S.No</th>
	<th>Item</th>
	<th>Price</th>
	<th></th>
	</tr>`;
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	let table = tables[tableNo];
	let { cost, orders: items } = table;
	let i = 1;
	if (Object.keys(items).length === 0) { // if items object is empty
		rows.innerHTML = `<tr><td colspan="6" style="text-align:center;">Table is empty. Please add items.</td></tr>`;
	} else {
	for (let [item, qty] of Object.entries(items)) {
		rows.insertAdjacentHTML(
			"beforeend",
			`
		<tr>
			<td>${i}.</td>
			<td>${menu[item].name}</td>
			<td>${menu[item].cost}</td>
			<td>${menu[item].cost*qty}</td>
			<td><input type="number" id="qty${i}" min = "1" value="${qty}" oninput="changeQty('${i}','${item}','${tableNo}')" /></td>
			<td><button id="delete" class="btn" onclick="deleteItem('${item}','${tableNo}')"><i class="fa fa-trash"></i></button></td>
		</tr>
		`
		);

		i++;
	}

	let total = document.getElementById("total");
	total.innerHTML = `TOTAL: ${cost}`;
	document.getElementById(
		"modal-footer"
	).innerHTML = `<p id="bill" onclick="generateBill('${tableNo}')" >GENERATE BILL</p>`;
}
}

//Drop start
function drag(e) {
	e.dataTransfer.setData("id", e.target.id);
}

//DropOver
//By default dropping is not allowed but we disable it
function allowDrop(e) {
 	e.preventDefault();
 }

//After dropping the item on table
function drop(e, tableName) {
	addItemToTable(tableName, e.dataTransfer.getData("id"));
	console.log(e.dataTransfer.getData("id"));
}

function addItemToTable(tableName, itemId) {
	console.log(tableName);
	console.log(itemId);
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	let item = menu[itemId];

	if (tables[tableName]["orders"][itemId] == undefined) {
		tables[tableName]["orders"][itemId] = 1;
	} else {
		tables[tableName]["orders"][itemId] += 1;
	}
	console.log(tables);

	//Displaying cost of items
	tables[tableName].cost += parseInt(item.cost);
	tables[tableName]["items"] += 1;
	sessionStorage.setItem("tables", JSON.stringify(tables));
	showTables();
}



//generate bill
function generateBill(){
	alert("Your bill has been generated.\n Thank you visit again");
}










//Object.keys(null)
//Object.assign(window.UndefinedVariable, {})


//Change quantity of item
function changeQty(i, itemId, tableNo) {
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	let table = tables[tableNo];
	let qty = document.getElementById(`qty${i}`).value;
	table.orders[itemId] = parseInt(qty);
	let items = 0;
	let total = 0;
	for (let [item, qty] of Object.entries(table.orders)) {
		items += qty;
		total += menu[item].cost * qty;
	}
	table.items = items;
	table.cost = total;
	sessionStorage.setItem("tables", JSON.stringify(tables));
	showTables();
	openBox(tableNo);
}


//Delete item from the order
function deleteItem(item, tableNo) {
	let tables = JSON.parse(sessionStorage.getItem("tables"));
	let table = tables[tableNo];
	let itemCost = menu[item].cost;
	let itemQty = table.orders[item];

	delete table.orders[item];

	table.cost -= itemCost * itemQty;
	table.items -= itemQty;
	tables[tableNo] = table;
	sessionStorage.setItem("tables", JSON.stringify(tables));
	showTables();
	openBox(tableNo);
}
