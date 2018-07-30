var type_value = [];
var data_value;
$.getJSON("../../resource/json/resource.json", function(data) {
	$.each(data, function(index, info) {
		type_value.push(index)
	});
	data_value = data;
	initPicker(type_value, data)
});
$("#getmore").click(function() {
	var con = "";
	con += '<li><form><div class="detail_list"><span>资源:</span>&nbsp;<input class="type_picker" value="资源类型" name="resource_type" readonly="">&nbsp;<input class="name_picker" value="资源名" name="resource_name" readonly="">';
	con += '<div class="res_num"><span>数量:</span>&nbsp;<div class="weui-count"><a class="weui-count__btn weui-count__decrease"></a>&nbsp;<input class="weui-count__number" type="number" value="1" name="resource_value"><span>KG</span>&nbsp;';
	con += '<a class="weui-count__btn weui-count__increase"></a></div>&nbsp<img src="../../resource/images/delete.png" /></div></div><form></li>';
	$('#resource_ul').append(con);
	var lis = document.getElementsByTagName("li");
	var index = lis.length;
	var li = lis[index - 1];
	var li_inputs = li.getElementsByTagName('input');
	var type = li_inputs[0];
	var number = li_inputs[2];
	type.setAttribute("name", "resource_type" + index);
	number.setAttribute("name", "resource_value" + index);
	var data = localStorage.data;
	initPicker(type_value, data_value)
});

function initPicker(type, data) {
	var names = [];
	$(".type_picker").picker({
		title: "请选择您的资源种类",
		cols: [{
			textAlign: 'center',
			values: type
		}],
		onChange: function(result) {
			names = [];
			var value = result.value.toString();
			var name = data[value];
			for(var i = 0; i < name.length; i++) {
				names.push(name[i + ''].resourceName)
			}
			$(result.input[0]).next()[0].remove();
			$(result.input[0]).after('&nbsp;<input class="name_picker" value="资源名" name="resource_name" readonly="">');
			initNamePicker(names)
		}
	});

	function initNamePicker(names) {
		$('.name_picker').picker({
			title: "请选择您的资源名字",
			cols: [{
				textAlign: 'center',
				values: names
			}]
		})
	}
	var MAX = 99,
		MIN = 1;
	$('.weui-count__decrease').click(function(e) {
		var $input = $(e.currentTarget).parent().find('.weui-count__number');
		var number = parseInt($input.val() || "0") - 1;
		if(number < MIN) number = MIN;
		$input.val(number)
	});
	$('.weui-count__increase').click(function(e) {
		var $input = $(e.currentTarget).parent().find('.weui-count__number');
		var number = parseInt($input.val() || "0") + 1;
		if(number > MAX) number = MAX;
		$input.val(number)
	})
}