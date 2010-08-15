#ifndef _CHAT_U_VOLCHAT__COMMAND_HPP_
#define _CHAT_U_VOLCHAT__COMMAND_HPP_

namespace com {
namespace uosipa {
namespace chatuvolchat {
    enum command_type
    {
        CHOOSE_ROOM,
        SEND_MESSAGE
    };

    struct command
    {
        command();

        command_type type;
        std::string body;
    };
} // chatuvolchat
} // uosipa
} // com

#endif
