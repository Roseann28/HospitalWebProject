appComponents.htmlForm.render.call({
    url: "finance/save",
    method: "POST",
    formTitle: 'Finances',
    renderId: "financeForm",
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
