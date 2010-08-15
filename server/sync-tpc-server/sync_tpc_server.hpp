#ifndef _CHAT_U_VOLCHAT__SYNC_TPC_SERVER_HPP_
#define _CHAT_U_VOLCHAT__SYNC_TPC_SERVER_HPP_

#include "logger.hpp"

#include <boost/smart_ptr.hpp>
#include <boost/asio.hpp>

#include <string>

namespace com {
namespace uosipa {
namespace chatuvolchat {
namespace server {
    typedef boost::shared_ptr<boost::asio::ip::tcp::socket> socket_ptr;

    enum server_state
    {
        RUNNING,
        STOPED
    };

    class sync_tpc_server
    {
    public:
        sync_tpc_server(const std::string& address, unsigned int port);

        void run();

    private:
        volatile server_state state;

        boost::asio::io_service io_service;
        boost::asio::ip::tcp::acceptor acceptor;

        void session(socket_ptr socket);
    };
} // namespace server
} // namespace chatuvolchat
} // namespace uosipa
} // namespace com

#endif // include guard
