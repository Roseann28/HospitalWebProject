appComponents.htmlForm.render.call({
    url: "service/save",
    method: "POST",
    formTitle: 'Services',
    renderId: "serviceForm",
    items: [{
        label: "Servie/Drug",
        name: "service",
        id: "service",
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
