package pojo;

public class TextMessage {

	//��������
		private String ToUserName;
		private String FromUserName;
		private long CreateTime;
		private String MsgType;
		private long MsgId;
		//�ظ�����Ϣ
		private String Content;
		
		
		public String getToUserName() {
			return ToUserName;
		}
		public void setToUserName(String toUserName) {
			ToUserName = toUserName;
		}
		public String getFromUserName() {
			return FromUserName;
		}
		public void setFromUserName(String fromUserName) {
			FromUserName = fromUserName;
		}
		public long getCreateTime() {
			return CreateTime;
		}
		public void setCreateTime(long createTime) {
			CreateTime = createTime;
		}
		public String getMsgType() {
			return MsgType;
		}
		public void setMsgType(String msgType) {
			MsgType = msgType;
		}
		public long getMsgId() {
			return MsgId;
		}
		public void setMsgId(long msgId) {
			MsgId = msgId;
		}
		public String getContent() {
			return Content;
		}
		public void setContent(String content) {
			Content = content;
		}
}
