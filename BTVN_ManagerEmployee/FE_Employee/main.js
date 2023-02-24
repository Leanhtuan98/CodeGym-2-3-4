//
//     function show() {
//     $.ajax({
//         type: "GET",
//         url: "http://localhost:8080/employee",
//         //xử lý khi thành công
//         success: function (data) {
//             let str = "";
//
//             for (let i = 0; i < data.length; i++) {
//                 str += "<tr>"
//                 str += `<td>${data[i].id}</td>`
//                 str += `<td>${data[i].name}</td>`
//                 str += `<td>${data[i].age}</td>`
//                 str += `<td>${data[i].salary}</td>`
//                 str += `<td>${data[i].branch}</td>`
//                 str += "</tr>"
//             }
//
//             document.getElementById("tbody").innerHTML = str;
//         },
//         error: function (err) {
//             console.log(err)
//         }
//     })
// }
//
//     show();
