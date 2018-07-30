package Proxy;


public class TwitterDemo {

	public static void main(String[] args) {

		TwitterService service = (TwitterService)SecurityProxy.newInstance(new TwitterServiceStub());
		//TwitterService service = (TwitterService)SecurityProxy.newInstance(new TwitterServiceImpl());

		TwitterService test = new TwitterServiceStub();

		System.out.println(service.getTimeline("JackLuo"));
		service.postToTimeline("", "");
		System.out.println("");

		System.out.println(test.getTimeline("JackLuo"));
		test.postToTimeline("", "");


		//service.postToTimeline("bh5k", "Some message that shouldn't go through.");
	}
}
