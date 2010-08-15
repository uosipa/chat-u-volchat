#include "sync_tpc_server.hpp"

#include <iostream>
#include <cstdlib>

int main(int argc, char* argv[])
{
    using std::cerr;
    using std::endl;
    using com::uosipa::chatuvolchat::server::sync_tpc_server;

    if (3 != argc)
    {
        cerr << "Usage: sync-tpc-server <address> <port>" << endl;
        cerr << "  Example:" << endl;
        cerr << "    sync-tpc-server 0.0.0.0 80" << endl;

        return EXIT_FAILURE;
    }

    sync_tpc_server server(argv[1], (unsigned int)atoi(argv[2]));
    server.run();

    return EXIT_SUCCESS;
}
