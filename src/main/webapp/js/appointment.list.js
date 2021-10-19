appComponents.htmlTable.renders.call({
    url: "http://localhost:8080/HospitalwebProject/appointment/view",
    tableTitle:'Service Table',
    renderTo: 'renderer',
    columns:[{
        label:"Id",
        dataIndex:"id",
    },{
        label:"Name",
        dataIndex: "name",
    },{
        label:"Quantity",
        dataIndex: "quantity",
    },{
        label: "Price",
        dataIndex: "price"
    }],
    buttons:[
        {
            id:'add.appointment',
            label:'add',
        }]
})