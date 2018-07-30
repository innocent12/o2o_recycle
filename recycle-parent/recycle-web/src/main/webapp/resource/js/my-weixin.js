/**
 * 
 */
/**
			 * ��ȡurl�еĲ���
			 * 
			 * @param {Object} name
			 */
			function getContextPath(){
				return "recycle-web";
			}
			
			function getQueryString(name) {
				var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
				var r = window.location.search.substr(1).match(reg);
				if(r != null) {
					return unescape(r[2]);
				}
				return null;
			}
			/**
			 * ΢��openid��¼
			 * @param code
			 */
			function OpenidLogin(code){
				var data = {'code':code };
				path = getContextPath();
				$.ajax({
					type:'POST',
					dataType:'json',
					url:"/"+path+"/"+'login/validWXLogin',
					contentType:'application/json;charset=utf-8',
					async:false,
					data: JSON.stringify(data),
					success:function(data){
						var message = data.msg;
						console.log(data);
						if(message == 'success'){
							$.toast("��¼�ɹ�"); //��ʾ�����ɹ�
							var storage = localStorage;
							storage["id"] = data.id; //idֵ

							localStorage.authlogin = 1; //�ж��û��Ƿ��¼����¼Ϊ1��δ��¼Ϊ0

							if(data.identity == 1) { //�����û�
								storage["name"] = data.sellername; //����
								storage["phone"] = data.sellerphone; //�绰
								storage["balance"] = data.sellerbalance; //���
								storage["level"] = data.sellerlevel; //�ȼ�
								storage["selleraddressarea"] = data.selleraddressarea;
								storage["selleraddressdetail"] = data.selleraddressdetail;
								storage["account"] = data.selleraccount;
							} else if(data.identity == 2) { //����Ա
								storage["name"] = data.collectorname; //����
								storage["phone"] = data.collectorphone; //�绰
								storage["balance"] = data.collectorbalance; //���
								storage["level"] = data.collectorlevel; //�ȼ�
								storage["addressid"] = data.addressid; //��������
								storage["addressArea"] = data.collectoraddressarea;
								storage["account"] = data.collectoraccount;
								window.location.href = "/common/collector/order.html";
							}
						}else if(message == 'fail'){
							window.location.href="/"+path+"/"+'common/user/estimate.html';
						}
					},
					error:function(){
						$.toast("����ʧ��", "forbidden"); //��ʾ����ʧ��
					}
				});
			}
			
			
			
			/**
			 * 判断是微信访问还是浏览器访问
			 */
			function is_weixin(){
				var client = window.navigator.userAgent.toLowerCase(); 
			    if (client.match(/MicroMessenger/i) == 'micromessenger') { 
			        return "weixin"; 
			    } else { 
			        return "browser"; 
			    } 
			}
			
			