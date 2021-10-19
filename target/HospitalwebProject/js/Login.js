appComponents.htmlForm.render.call({
    url:'./login',
    method:'POST',
    formTitle: 'Login',
    renderId: "loginForm",
    items: [{
        label: "Staff ID",
        name: "staffId",
        id: "staffId",
        type: "text"
    },{
        label: "Password",
        name: "password",
        id: "password",
        type: "password"
    }],
    submitBtn: {
        type: 'submit',
        value: 'Submit'
    }
});