#include "sync_tpc_server.hpp"
#include "strings.hpp"

#include <boost/bind.hpp>
#include <boost/thread/thread.hpp>
#include <boost/thread/mutex.hpp>

using namespace com::uosipa::chatuvolchat;
using namespace com::uosipa::chatuvolchat::server;

using boost::asio::ip::tcp;

using namespace std;

logger logger_("server");

sync_tpc_server::sync_tpc_server(const std::string& address, unsigned int port):
acceptor(io_service, tcp::endpoint(tcp::v4(), port)), state(RUNNING)
{
    // No operations.
}

void sync_tpc_server::run()
{
    logger_.info("Server started.");

    while (RUNNING == state)
    {
        try
        {
            socket_ptr socket(new tcp::socket(io_service));
            acceptor.accept(*socket);
            boost::thread client_thread(boost::bind(&sync_tpc_server::session, this, socket));
        }
        catch (boost::thread_resource_error&)
        {
            logger_.warn("Can't create new thread. Thread resource error.");
        }
        catch (exception& e)
        {
            logger_.warn("Exception: '" + (string)e.what() + "'.");
        }
    }
}

void sync_tpc_server::session(socket_ptr socket)
{
    string remote_endpoint = socket->remote_endpoint().address().to_string() +
        ":" + to_string(socket->remote_endpoint().port());

    logger_.info("Connected client from host '" + remote_endpoint + "'.");

    logger client_logger(remote_endpoint);

    try
    {
        // TODO
        /*
        for (;;)
        {

        }
        */
    }
    catch (exception& e)
    {
        client_logger.warn("Exception: '" + (string)e.what() + "'.");
    }
}
