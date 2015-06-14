import com.rabbitmq.client._

/**
 * Created by BPK_t on 2015/06/14.
 */
object Main {
  val QUEUE_NAME="test_queue"

  def main(args: Array[String]) {

    val p = new Producer(QUEUE_NAME)
    val c = new Consumer(QUEUE_NAME)

    p.send()
    c.receive()

    p.close()
    c.close()
  }
}
