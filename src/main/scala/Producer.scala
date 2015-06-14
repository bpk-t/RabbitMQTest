import com.rabbitmq.client.ConnectionFactory

/**
 * Created by BPK_t on 2015/06/14.
 */
class Producer(queueName : String) {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection = factory.newConnection()
  val channel = connection.createChannel()

  channel.queueDeclare(queueName, false, false, false, null)

  def send():Unit={
    var message = "Hello World!"
    channel.basicPublish("", queueName, null, message.getBytes())
    println(" [x] Sent '" + message + "'")
  }

  def close():Unit={
    channel.close()
    connection.close()
  }
}
