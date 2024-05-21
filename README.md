The hr-managemnt-app is an application that houses three application, the finance-manager, the human-manager and the configapp.
The human-manager app receives Employee information of Employee in an organazition and sends this information through a Apache kafka messaging service to the finance-manager app where approval
is carried out based on the infomation sent. The condition upon which approval os met is that the employee has to have an "employeeKycPoint" greater of equal to 50 before such record can be approved.
Upon approval of the employee information by the finance department of the organization, an email is end to indicate that the approval is successful. This email is sent the the empoyee's email provided.
The config app is the application that handles the management of the properties config of both applications. The properties of both application are externally decleared in a file on github and is been access by the config app to the individual application.
