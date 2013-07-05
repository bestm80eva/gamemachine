module GameMachine
  module Systems
    class ChatTopic < Actor

      def post_init(*args)
        @player_id = args.first
        @client_connection = args.last
      end

      def on_receive(message)
        if message.is_a?(String)
          receive_chat_message(message)
        elsif message.is_a?(JavaLib::DistributedPubSubMediator::SubscribeAck)
          return
        else
          unhandled(message)
        end
      end

      private

      def receive_chat_message(text)
        message = GameMachine::Helpers::GameMessage.new(@player_id)
        message.chat_message('group',text,@player_id)
        client_message = message.client_message
        client_message.set_client_connection(@client_connection)
        client_message.send_to_client
      end

    end
  end
end
