import com.rabbitmq.client._

/**
 * Created by BPK_t on 2015/06/14.
 */
class Consumer(queueName : String) {
  val factory = new ConnectionFactory()
  factory.setHost("localhost")
  val connection = factory.newConnection()
  val channel = connection.createChannel()

  val consumer = new QueueingConsumer(channel)
  channel.basicConsume(queueName, true, consumer)

  def receive():Unit={
    val delivery = consumer.nextDelivery()
    val message = new String(delivery.getBody())
    println(" [x] Received '" + message + "'")
  }

  def close():Unit={
    channel.close()
    connection.close()
  }
}
