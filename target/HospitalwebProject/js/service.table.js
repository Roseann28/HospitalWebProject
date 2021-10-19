let servicedetails={
    url: "http://localhost:8080/HospitalwebProject/service/list",
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
            id:'add.service',
            label:'add',
            handler: function () {
                appComponents.htmlForm.render.call({
                    url: "service/save",
                    method: "POST",
                    formTitle: 'Services',
                    renderId:'renderer',
                    items: [{
                        label: "Servie/Drug",
                        name: "name",
                        id: "name",
                        type: "text"
                    },{
                        label: "Quantity",
                        name: "quantity",
                        id: "quantity",
                        type: "number"
                    },{
                        label: "Price",
                        name: "price",
                        id: "price",
                        type: "number"
                    }],
                    submitBtn: {
                        type: 'submit',
                        value: 'Submit'
                    }
                });


            }
        }]
}