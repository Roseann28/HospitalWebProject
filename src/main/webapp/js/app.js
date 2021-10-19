let appNavBarLinks = {
    renderTo: "topnavbar",
    links: [{
        label: "Patients",
        id: "patient.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(patientdetails);

        }
    },{
        label: "ailments",
        id: "ailment.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(ailmentlist);

        }
    },{
        label: "Basic",
        id: "basic.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(basiclist);

        }
    },{
        label: "Finance",
        id: "finance.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(financedetails);


        }
    },{
        label: "Services",
        id: "service.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(servicedetails);

        }
    },{
        label: "Tests",
        id: "test.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(testdetails);

        }
    },{
        label: "Admit",
        id: "admit.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(admitdetails);

        }
    },{
        label: "Department",
        id: "department.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(departmentdetails);

        }
    },{
        label: "Staff",
        id: "staff.link",
        handler: function(){
            let me = this;

            appComponents.htmlToNavBar.changeStyle.call(appNavBarLinks, me.id);
            appComponents.htmlTable.renders.apply(staffdetails);


        }
    }]
};

appComponents.htmlToNavBar.render.call(appNavBarLinks);