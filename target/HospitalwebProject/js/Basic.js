appComponents.htmlForm.render.call({
        url: "basics/save",
        method: "POST",
        formTitle: 'Basic Measurements',
        renderId: "basicForm",
        items: [{
            label: "Patient ID",
            name: "id",
            id: "id",
            type: "number"
        },{
            label: "Height",
            name: "height",
            id: "height",
            type: "number"
        },{
            label: "Height Unit",
            name: "heightUnit",
            id: "heightUnit",
            type: "text"
        },{
            label: "Weight",
            name: "weight",
            id: "weight",
            type: "number"
        },{
            label: "Weight Unit",
            name: "weightUnit",
            id: "weightUnit",
            type: "text"
        },{
            label: "Blood Pressure",
            name: "bloodPressure",
            id: "bloodPressure",
            type: "text"
        }],
        submitBtn: {
            type: 'submit',
            value: 'Submit'
        }
    });
