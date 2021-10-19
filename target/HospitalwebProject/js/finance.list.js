let financedetails={
    url: "http://localhost:8080/HospitalwebProject/finance/list",
    tableTitle:'Finance Table',
    renderTo: 'renderer',
    columns:[{
        label:"Patient Id",
        dataIndex:"patientId",
    },{
        label:"Service/Drug",
        dataIndex: "service",
    },{
        label:"Quantity",
        dataIndex: "quantity",
    },{
        label: "fee",
        dataIndex: "fee"
    },{
        label: "Total fee",
        dataIndex: "totalfee"
    }],
    buttons:[
        {
            id:'add.finance',
            label:'add',
            handler:function(){
            appComponents.htmlForm.render.call({
                url: "finance/save",
                method: "POST",
                formTitle: 'Finances',
                renderId: "renderer",
                items: [{
                    label: "Patient Id",
                    name: "patientId",
                    id: "patientId",
                    type: "number"
                },{
                    label: "service",
                    name: "service",
                    id: "service",
                    type: "select",
                    select: {
                        url: './service/list',
                        optionMap:{value: 'name', display: 'name'}
                    },
                },{
                    label: "Quantity",
                    name: "quantity",
                    id: "quantity",
                    type: "number"
                },{
                    label: "Fee",
                    name: "fee",
                    id: "fee",
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